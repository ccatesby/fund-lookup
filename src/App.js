import React from 'react';
import { GraphQLClient, ClientContext } from 'graphql-hooks'
import { Dashboard } from "./components/dashboard";

const App = () => {
  const client = new GraphQLClient({
    url: 'http://localhost:8080/graphql'
  });

  return (
    <ClientContext.Provider value={client}>
      <Dashboard />
    </ClientContext.Provider>
  );
}

export default App;
