import Head from "next/head";
import PlusIcon from "@heroicons/react/24/solid/PlusIcon";
import {
  Box,
  Button,
  Container,
  Pagination,
  Stack,
  SvgIcon,
  Typography,
  Unstable_Grid2 as Grid,
  Link,
} from "@mui/material";
import { Layout as DashboardLayout } from "src/layouts/dashboard/layout";
import { CompanyCard } from "src/sections/companies/company-card";
import { CompaniesSearch } from "src/sections/companies/companies-search";

const companies = [
  {
    id: "84572fb6329236a1d6d1f546",
    createdAt: "15/05/2022",
    description:
      "A1 is a leading telecommunications provider offering mobile, fixed-line, and internet services.",
    logo: "https://upload.wikimedia.org/wikipedia/commons/9/98/A1_red_logo.png",
    title: "A1",
    downloads: "800",
  },
  {
    id: "98b6f3e4a0ce7d82e5d2a781",
    createdAt: "19/08/2023",
    description:
      "Telekom is the largest telecommunications provider in the country, offering a wide range of services including mobile, fixed-line, and internet.",
    logo: "https://yt3.googleusercontent.com/ytc/AIf8zZQyD8svu-vrX9t8RGJ_6di5d_uaP__QNL0xsXNufQ=s900-c-k-c0x00ffffff-no-rj",
    title: "Telekom",
    downloads: "950",
  },
  {
    id: "e372afde5f291ee30e7d70fb",
    createdAt: "02/11/2023",
    description:
      "T2 provides telecommunications services with a focus on mobile and internet offerings.",
    logo: "https://d3kojuroqw7fww.cloudfront.net/fileadmin/_processed_/e/4/csm_t2_407dd92cd1.png",
    title: "T2",
    downloads: "720",
  },
  {
    id: "a0b1c2d3e4f5g6h7i8j9k0l",
    createdAt: "10/12/2024",
    description:
      "Vodafone is a multinational telecommunications company providing a range of services including mobile, fixed-line, and internet.",
    logo: "https://play-lh.googleusercontent.com/r7R-tyq4GQapq7uKeCHL8zwqF3avIx3HpTxZ3B0b5l8t1pZWw6s4AOJXAKJuhlnVkg",
    title: "Vodafone",
    downloads: "850",
  },
  {
    id: "m1n2o3p4q5r6s7t8u9v0w",
    createdAt: "09/05/2024",
    description:
      "Telemach is a global telecommunications company offering mobile, fixed-line, and internet services.",
    logo: "https://play-lh.googleusercontent.com/LTBkhIOlC1AcS2RguQMKPeyUhLaEWleYsgMU4VmEsc-zB8zGcGMOA4KlOe2wOB-i7i6N=w600-h300-pc0xffffff-pd",
    title: "Telemach",
    downloads: "780",
  },
  {
    id: "x1y2z3a4b5c6d7e8f9g0h",
    createdAt: "18/06/2023",
    description:
      "AT&T is a multinational telecommunications conglomerate providing a wide range of services including mobile, fixed-line, and internet.",
    logo: "https://s3-symbol-logo.tradingview.com/at-and-t--600.png",
    title: "AT&T",
    downloads: "920",
  },
];

const Page = () => (
  <>
    <Head>
      <title>Companies</title>
    </Head>
    <Box
      component="main"
      sx={{
        flexGrow: 1,
        py: 8,
      }}
    >
      <Container maxWidth="xl">
        <Stack spacing={3}>
          <Stack direction="row" justifyContent="space-between" spacing={4}>
            <Stack spacing={1}>
              <Typography variant="h4">Companies</Typography>
              <Stack alignItems="center" direction="row" spacing={1}></Stack>
            </Stack>
            <div>
              <Button
                startIcon={
                  <SvgIcon fontSize="small">
                    <PlusIcon />
                  </SvgIcon>
                }
                variant="contained"
              >
                Add
              </Button>
            </div>
          </Stack>
          <CompaniesSearch />
          <Grid container spacing={3}>
            {companies.map((company) => (
              <Grid xs={12} md={6} lg={4} key={company.id}>
                <Link href="/internet">
                  <CompanyCard company={company} />
                </Link>
              </Grid>
            ))}
          </Grid>
          <Box
            sx={{
              display: "flex",
              justifyContent: "center",
            }}
          >
            <Pagination count={3} size="small" />
          </Box>
        </Stack>
      </Container>
    </Box>
  </>
);

Page.getLayout = (page) => <DashboardLayout>{page}</DashboardLayout>;

export default Page;
