// @flow
import React from 'react';
import { Router } from '@reach/router';
import { Layout } from './Layout';
import { ListFunds } from './ListFunds';
import { ListFundHoldings } from './ListFundHoldings';
import { Dashboard } from './Dashboard';

const Site = () => {
  return (
    <Router>
      <Layout path="/">
        <ListFunds path="/funds/" />
        <ListFundHoldings path="/holdings/:fundId" />
        <Dashboard path="dashboard" />
      </Layout>
    </Router>
  );
};

export { Site };
