import React, { useState } from 'react';
import SockJsClient from 'react-stomp';

const SOCKET_URL = 'http://localhost:8080/ws-chat/';

const RealTime = () => {
  const [messages, setMessages] = useState([]);

  let onConnected = () => {
    console.log('Connected!!');
  };

  let onMessageReceived = (msg) => {
    console.log('New Message Received!!', msg);
    setMessages(messages.concat(msg));
  };

  return (
    <div>
      <>
        <SockJsClient
          url={SOCKET_URL}
          topics={['/topic/group']}
          onConnect={onConnected}
          onDisconnect={console.log('Disconnected!')}
          onMessage={(msg) => onMessageReceived(msg)}
          debug={false}
        />
      </>
    </div>
  );
};

export { RealTime };
