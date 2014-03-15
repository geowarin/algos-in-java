package com.algos.union;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author Sennen
 * @since 31/12/13 22:50
 */
public class QuickUnionConnectorTest {
    private Connector connector;

    @Before
    public void setUp() throws IOException {
        connector = ConnectorParser.parse(QuickUnionConnectorTest.class.getResource("simpleConnector.txt").getPath(),
                                          QuickUnionConnector::new);
    }

    @Test
    public void testConnected() throws Exception {
        TestCase.assertTrue(connector.connected(4, 9));
        TestCase.assertTrue(connector.connected(6, 7));
    }

    @Test
    public void testCount() throws Exception {
        TestCase.assertEquals(2, connector.getNumberOfComponents());
    }
}