import React from 'react';
import { GraphQLClient, ClientContext } from 'graphql-hooks'
import { Site } from './pages/Site';

const App = () => {
  const client = new GraphQLClient({
    url: 'http://localhost:8080/graphql'
  });

  return (
    <ClientContext.Provider value={client}>
      <Site />
    </ClientContext.Provider>
  );
}

export default App;
