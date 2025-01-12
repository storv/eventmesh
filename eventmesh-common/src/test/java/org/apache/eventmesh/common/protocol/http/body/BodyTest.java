/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.eventmesh.common.protocol.http.body;

import org.apache.eventmesh.common.protocol.http.body.client.HeartbeatRequestBody;
import org.apache.eventmesh.common.protocol.http.body.client.RegRequestBody;
import org.apache.eventmesh.common.protocol.http.body.client.SubscribeRequestBody;
import org.apache.eventmesh.common.protocol.http.body.client.UnRegRequestBody;
import org.apache.eventmesh.common.protocol.http.body.client.UnSubscribeRequestBody;
import org.apache.eventmesh.common.protocol.http.body.message.PushMessageRequestBody;
import org.apache.eventmesh.common.protocol.http.body.message.ReplyMessageRequestBody;
import org.apache.eventmesh.common.protocol.http.body.message.SendMessageBatchRequestBody;
import org.apache.eventmesh.common.protocol.http.body.message.SendMessageBatchV2RequestBody;
import org.apache.eventmesh.common.protocol.http.body.message.SendMessageRequestBody;
import org.apache.eventmesh.common.protocol.http.common.RequestCode;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BodyTest {

    private Map<String, Object> originalMap;

    @Before
    public void before() {
        originalMap = new HashMap<>();
    }

    @Test
    public void testBuildBody() throws Exception {
        Assert.assertThrows(Exception.class, () -> Body.buildBody("-1", originalMap));
        Body sendMessageBatchRequestBody = Body.buildBody(String.valueOf(RequestCode.MSG_BATCH_SEND.getRequestCode()), originalMap);
        Assert.assertNotNull(sendMessageBatchRequestBody);
        Assert.assertEquals(sendMessageBatchRequestBody.getClass(), SendMessageBatchRequestBody.class);
        Body sendMessageBatchV2RequestBody = Body.buildBody(String.valueOf(RequestCode.MSG_BATCH_SEND_V2.getRequestCode()), originalMap);
        Assert.assertNotNull(sendMessageBatchV2RequestBody);
        Assert.assertEquals(sendMessageBatchV2RequestBody.getClass(), SendMessageBatchV2RequestBody.class);
        Body sendMessageRequestBodySync = Body.buildBody(String.valueOf(RequestCode.MSG_SEND_SYNC.getRequestCode()), originalMap);
        Assert.assertNotNull(sendMessageRequestBodySync);
        Assert.assertEquals(sendMessageRequestBodySync.getClass(), SendMessageRequestBody.class);
        Body sendMessageRequestBodyAsync = Body.buildBody(String.valueOf(RequestCode.MSG_SEND_ASYNC.getRequestCode()), originalMap);
        Assert.assertNotNull(sendMessageRequestBodyAsync);
        Assert.assertEquals(sendMessageRequestBodyAsync.getClass(), SendMessageRequestBody.class);
        Body pushMessageRequestBodySync = Body.buildBody(String.valueOf(RequestCode.HTTP_PUSH_CLIENT_SYNC.getRequestCode()), originalMap);
        Assert.assertNotNull(pushMessageRequestBodySync);
        Assert.assertEquals(pushMessageRequestBodySync.getClass(), PushMessageRequestBody.class);
        Body pushMessageRequestBodyAsync = Body.buildBody(String.valueOf(RequestCode.HTTP_PUSH_CLIENT_ASYNC.getRequestCode()), originalMap);
        Assert.assertNotNull(pushMessageRequestBodyAsync);
        Assert.assertEquals(pushMessageRequestBodyAsync.getClass(), PushMessageRequestBody.class);
        Body regRequestBody = Body.buildBody(String.valueOf(RequestCode.REGISTER.getRequestCode()), originalMap);
        Assert.assertNotNull(regRequestBody);
        Assert.assertEquals(regRequestBody.getClass(), RegRequestBody.class);
        Body unRegRequestBody = Body.buildBody(String.valueOf(RequestCode.UNREGISTER.getRequestCode()), originalMap);
        Assert.assertNotNull(unRegRequestBody);
        Assert.assertEquals(unRegRequestBody.getClass(), UnRegRequestBody.class);
        Body subscribeRequestBody = Body.buildBody(String.valueOf(RequestCode.SUBSCRIBE.getRequestCode()), originalMap);
        Assert.assertNotNull(subscribeRequestBody);
        Assert.assertEquals(subscribeRequestBody.getClass(), SubscribeRequestBody.class);
        Body unSubscribeRequestBody = Body.buildBody(String.valueOf(RequestCode.UNSUBSCRIBE.getRequestCode()), originalMap);
        Assert.assertNotNull(unSubscribeRequestBody);
        Assert.assertEquals(unSubscribeRequestBody.getClass(), UnSubscribeRequestBody.class);
        Body heartbeatRequestBody = Body.buildBody(String.valueOf(RequestCode.HEARTBEAT.getRequestCode()), originalMap);
        Assert.assertNotNull(heartbeatRequestBody);
        Assert.assertEquals(heartbeatRequestBody.getClass(), HeartbeatRequestBody.class);
        Body replyMessageRequestBody = Body.buildBody(String.valueOf(RequestCode.REPLY_MESSAGE.getRequestCode()), originalMap);
        Assert.assertNotNull(replyMessageRequestBody);
        Assert.assertEquals(replyMessageRequestBody.getClass(), ReplyMessageRequestBody.class);
        Body baseRequestBody = Body.buildBody(String.valueOf(RequestCode.ADMIN_SHUTDOWN.getRequestCode()), originalMap);
        Assert.assertNotNull(baseRequestBody);
        Assert.assertEquals(baseRequestBody.getClass(), BaseRequestBody.class);
    }
}
