// @flow
import React from 'react';
import { Router } from '@reach/router';
import { Layout } from './Layout';
import { ListFunds } from './ListFunds';
import { ListFundHoldings } from './ListFundHoldings';
import { Dashboard } from './Dashboard';
import { RealTime } from './RealTime';

const Site = () => {
  return (
    <Router>
      <Layout path="/">
        <ListFunds path="/funds/" />
        <ListFundHoldings path="/holdings/:fundId" />
        <Dashboard path="dashboard" />
        <RealTime path="realtime" />
      </Layout>
    </Router>
  );
};

export { Site };
