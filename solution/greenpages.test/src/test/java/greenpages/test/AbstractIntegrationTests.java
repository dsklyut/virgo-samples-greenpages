package greenpages.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.osgi.framework.*;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

import org.eclipse.virgo.kernel.deployer.core.ApplicationDeployer;
import org.eclipse.virgo.kernel.deployer.core.DeploymentException;
import org.eclipse.virgo.kernel.deployer.core.DeploymentIdentity;
import org.eclipse.virgo.test.framework.dmkernel.DmKernelTestRunner;
import org.springframework.osgi.util.OsgiServiceReferenceUtils;

/**
 * User: dsklyut
 * Date: Jan 11, 2010
 * Time: 12:02:22 PM
 */
@RunWith(DmKernelTestRunner.class)
public abstract class AbstractIntegrationTests {

    private static final CountDownLatch latch = new CountDownLatch(1);

    private BundleContext context;

    private ApplicationDeployer deployer;
    private ConfigurationAdmin configAdmin;

    protected BundleContext getContext() {
        return context;
    }

    protected ApplicationDeployer getDeployer() {
        return deployer;
    }

    protected ConfigurationAdmin getConfigAdmin() {
        return configAdmin;
    }

    protected DeploymentIdentity deploy(String path) throws DeploymentException {
        File f = new File(path);
        assertTrue(f.getAbsolutePath() + " does not exist.", f.exists());
        return getDeployer().deploy(f.toURI());
    }

    @BeforeClass
    public static void registerEventHandler() {

        EventHandler eventHandler = new InitialArtifactDeploymentAwaitingEventHandler();

        Properties properties = new Properties();
        properties.setProperty("event.topics", "org/eclipse/virgo/kernel/*");

        FrameworkUtil.getBundle(AbstractIntegrationTests.class).getBundleContext().registerService(EventHandler.class.getName(), eventHandler, properties);
    }

    private static final class InitialArtifactDeploymentAwaitingEventHandler implements EventHandler {

        public void handleEvent(Event event) {
            if ("org/eclipse/virgo/kernel/userregion/systemartifacts/DEPLOYED".equals(event.getTopic())) {
                latch.countDown();
            }
        }
    }

    @Before
    public void setUp() throws Exception {
        try {
            if (!latch.await(30, TimeUnit.SECONDS)) {
                fail("System artifacts were not deployed within 30 seconds");
            }
        } catch (InterruptedException e) {
            Thread.interrupted();
            fail("System artifacts were not deployed within 30 seconds");
        }

        this.context = FrameworkUtil.getBundle(getClass()).getBundleContext();

        this.deployer = lookupService(ApplicationDeployer.class);
        this.configAdmin = lookupService(ConfigurationAdmin.class);
    }


    protected <T> T lookupService(Class<T> clazz) {
        return lookupService(getContext(), clazz);
    }

    protected <T> T lookupService(BundleContext bundleContext, Class<T> clazz) {
        ServiceReference ref = bundleContext.getServiceReference(clazz.getName());
        assertNotNull(clazz.getSimpleName() + " service reference not found", ref);
        T result = clazz.cast(bundleContext.getService(ref));
        assertNotNull(clazz.getSimpleName() + " service not found", result);
        return result;
    }

    @SuppressWarnings("unchecked")
    protected <T> T lookupService(BundleContext bundleContext, Class<T> clazz, String filter) throws InvalidSyntaxException {
        ServiceReference ref = OsgiServiceReferenceUtils.getServiceReference(bundleContext, clazz.getName(), filter);
        if (ref == null) {
            return null;
        }
        return (T) bundleContext.getService(ref);
    }
}