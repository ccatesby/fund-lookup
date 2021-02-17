// @flow
import React from 'react';
import { Router } from '@reach/router';
import { Layout } from './Layout';
import { ListFunds } from './ListFunds';
import { ListStocks } from './ListStocks';
import { Dashboard } from './Dashboard';

const Site = () => {
  return (
    <Router>
      <Layout path="/">
        <ListFunds path="/funds/" />
        <ListStocks path="/stocks/:fundId" />
        <Dashboard path="dashboard" />
      </Layout>
    </Router>
  );
};

export { Site };
