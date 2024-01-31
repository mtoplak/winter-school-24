import Head from "next/head";
import { Box, Container, Unstable_Grid2 as Grid } from "@mui/material";
import { Layout as DashboardLayout } from "src/layouts/dashboard/layout";
import { OverviewBudget } from "src/sections/overview/overview-budget";
import { OverviewLatestOrders } from "src/sections/overview/overview-latest-orders";
import { OverviewSales } from "src/sections/overview/overview-sales";
import { OverviewTasksProgress } from "src/sections/overview/overview-tasks-progress";
import { OverviewTasksProgress2 } from "src/sections/overview/overview-obdobje";
import { OverviewTotalProfit } from "src/sections/overview/overview-total-profit";
import { OverviewTraffic } from "src/sections/overview/overview-traffic";
import { useSubContext } from "src/contexts/SubContext";
const currentYear = new Date().getFullYear();

const Page = () => {
  const { stroski } = useSubContext();
  return (
    <>
      <Head>
        <title>My Portal</title>
      </Head>
      <Box
        component="main"
        sx={{
          flexGrow: 1,
          py: 8,
        }}
      >
        <Container maxWidth="xl">
          <Grid container spacing={3}>
            <Grid xs={12} sm={6} lg={3}>
              <OverviewTasksProgress2 ime="Računsko obdobje" sx={{ height: "100%" }} value={20} />
            </Grid>
            <Grid xs={12} sm={6} lg={3}>
              {/* <OverviewTotalCustomers
              difference={16}
              positive={false}
              sx={{ height: "100%" }}
              value="1.6k"
            /> */}
              <OverviewBudget difference={12} positive sx={{ height: "100%" }} value="284€" />
            </Grid>
            <Grid xs={12} sm={6} lg={3}>
              <OverviewTasksProgress ime="Trenutna poraba" sx={{ height: "100%" }} value={66.6} />
            </Grid>
            <Grid xs={12} sm={6} lg={3}>
              <OverviewTotalProfit sx={{ height: "100%" }} value="5k€" />
            </Grid>
            <Grid xs={12} lg={8}>
              <OverviewLatestOrders
                orders={[
                  {
                    id: "f69f88012978187a6c12897f",
                    ref: "Mobilni paket 1",
                    amount: 30.5,
                    customer: { name: "A1" },
                    createdAt: new Date(currentYear, 0, 1, 0, 0, 0, 0).getTime(),
                    status: "pending",
                  },
                  {
                    id: "9eaa1c7dd4433f413c308ce2",
                    ref: "Stacionarna telefonija",
                    amount: 25.1,
                    customer: { name: "Telemach" },
                    createdAt: new Date(currentYear, 0, 15, 0, 0, 0, 0).getTime(),
                    status: "subscribed",
                  },
                  {
                    id: "01a5230c811bd04996ce7c13",
                    ref: "Internet 3",
                    amount: 10.99,
                    customer: { name: "T2" },
                    createdAt: new Date(currentYear, 1, 1, 0, 0, 0, 0).getTime(),
                    status: "cancelled",
                  },
                  {
                    id: "1f4e1bd0a87cea23cdb83d18",
                    ref: "DEV1046",
                    amount: 96.43,
                    customer: { name: "A1" },
                    createdAt: new Date(currentYear, 1, 2, 0, 0, 0, 0).getTime(),
                    status: "pending",
                  },
                  {
                    id: "9f974f239d29ede969367103",
                    ref: "Paket 532",
                    amount: 32.54,
                    customer: { name: "Telekom" },
                    createdAt: new Date(currentYear, 1, 3, 0, 0, 0, 0).getTime(),
                    status: "subscribed",
                  },
                ]}
                sx={{ height: "100%" }}
              />
            </Grid>
            <Grid xs={12} md={6} lg={4}>
              <OverviewTraffic
                chartSeries={[63, 15, stroski]}
                labels={["Internet", "TV", "Phone"]}
                sx={{ height: "100%" }}
              />
            </Grid>
            <Grid xs={12} md={12} lg={8}>
              <OverviewSales
                chartSeries={[
                  {
                    name: "This year",
                    data: [18, 16, 5, 8, 3, 14, 14, 16, 17, 19, 18, 20],
                  },
                  {
                    name: "Last year",
                    data: [12, 11, 4, 6, 2, 9, 9, 10, 11, 12, 13, 13],
                  },
                ]}
                sx={{ height: "100%" }}
              />
            </Grid>
          </Grid>
        </Container>
      </Box>
    </>
  );
};

Page.getLayout = (page) => <DashboardLayout>{page}</DashboardLayout>;

export default Page;
