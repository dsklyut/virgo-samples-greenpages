/*******************************************************************************
 * Copyright (c) 2008, 2010 VMware Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   VMware Inc. - initial contribution
 *******************************************************************************/

package greenpages.jpa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.core.io.Resource;

/**
 * A class that populates a datasource with test data
 */
public class TestDataPopulator {

    private final DataSource dataSource;

    private final Resource testDataLocation;

    public TestDataPopulator(DataSource dataSource, Resource testDataLocation) {
        this.dataSource = dataSource;
        this.testDataLocation = testDataLocation;
    }

    public void populate() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            insertTestData(connection);
        } catch (SQLException e) {
            throw new RuntimeException("SQL exception occurred acquiring connection", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    private void insertTestData(Connection connection) {
        try {
            String sql = parseSqlIn(testDataLocation);
            executeSql(sql, connection);
        } catch (IOException e) {
            throw new RuntimeException("I/O exception occurred accessing the test data file", e);
        } catch (SQLException e) {
            throw new RuntimeException("SQL exception occurred loading test data", e);
        }
    }

    private String parseSqlIn(Resource resource) throws IOException {
        InputStream is = null;
        try {
            is = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            StringWriter sw = new StringWriter();
            BufferedWriter writer = new BufferedWriter(sw);

            for (int c = reader.read(); c != -1; c = reader.read()) {
                writer.write(c);
            }
            writer.flush();
            return sw.toString();

        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    private void executeSql(String sql, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }
}
