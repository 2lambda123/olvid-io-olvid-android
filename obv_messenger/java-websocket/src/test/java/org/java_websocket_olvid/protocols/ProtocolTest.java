/*
 *  Olvid for Android
 *  Copyright © 2019-2022 Olvid SAS
 *
 *  This file is part of Olvid for Android.
 *
 *  Olvid is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Affero General Public License, version 3,
 *  as published by the Free Software Foundation.
 *
 *  Olvid is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Affero General Public License for more details.
 *
 *  You should have received a copy of the GNU Affero General Public License
 *  along with Olvid.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.java_websocket_olvid.protocols;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ProtocolTest {

  @Test
  public void testConstructor() throws Exception {
    Protocol protocol0 = new Protocol("");
    try {
      Protocol protocol1 = new Protocol(null);
      fail("IllegalArgumentException expected");
    } catch (IllegalArgumentException e) {
      //Fine
    }
  }

  @Test
  public void testAcceptProvidedProtocol() throws Exception {
    Protocol protocol0 = new Protocol("");
    assertTrue(protocol0.acceptProvidedProtocol(""));
    assertTrue(protocol0.acceptProvidedProtocol("chat"));
    assertTrue(protocol0.acceptProvidedProtocol("chat, test"));
    assertTrue(protocol0.acceptProvidedProtocol("chat, test,"));
    Protocol protocol1 = new Protocol("chat");
    assertTrue(protocol1.acceptProvidedProtocol("chat"));
    assertFalse(protocol1.acceptProvidedProtocol("test"));
    assertTrue(protocol1.acceptProvidedProtocol("chat, test"));
    assertTrue(protocol1.acceptProvidedProtocol("test, chat"));
    assertTrue(protocol1.acceptProvidedProtocol("test,chat"));
    assertTrue(protocol1.acceptProvidedProtocol("chat,test"));
    assertTrue(protocol1.acceptProvidedProtocol("asdchattest,test, chat"));
  }

  @Test
  public void testGetProvidedProtocol() throws Exception {
    Protocol protocol0 = new Protocol("");
    assertEquals("", protocol0.getProvidedProtocol());
    Protocol protocol1 = new Protocol("protocol");
    assertEquals("protocol", protocol1.getProvidedProtocol());
  }

  @Test
  public void testCopyInstance() throws Exception {
    IProtocol protocol0 = new Protocol("");
    IProtocol protoocl1 = protocol0.copyInstance();
    assertEquals(protocol0, protoocl1);
    IProtocol protocol2 = new Protocol("protocol");
    IProtocol protocol3 = protocol2.copyInstance();
    assertEquals(protocol2, protocol3);
  }

  @Test
  public void testToString() throws Exception {
    Protocol protocol0 = new Protocol("");
    assertEquals("", protocol0.getProvidedProtocol());
    Protocol protocol1 = new Protocol("protocol");
    assertEquals("protocol", protocol1.getProvidedProtocol());
  }

  @Test
  public void testEquals() throws Exception {
    Protocol protocol0 = new Protocol("");
    Protocol protocol1 = new Protocol("protocol");
    Protocol protocol2 = new Protocol("protocol");
    assertTrue(!protocol0.equals(protocol1));
    assertTrue(!protocol0.equals(protocol2));
    assertTrue(protocol1.equals(protocol2));
    assertTrue(!protocol1.equals(null));
    assertTrue(!protocol1.equals(new Object()));
  }

  @Test
  public void testHashCode() throws Exception {
    Protocol protocol0 = new Protocol("");
    Protocol protocol1 = new Protocol("protocol");
    Protocol protocol2 = new Protocol("protocol");
    assertNotEquals(protocol0, protocol1);
    assertNotEquals(protocol0, protocol2);
    assertEquals(protocol1, protocol2);
  }

}