import {
  Avatar,
  Box,
  Button,
  Card,
  CardContent,
  Divider,
  Stack,
  Typography,
  SvgIcon,
} from "@mui/material";
import PlusIcon from "@heroicons/react/24/solid/PlusIcon";

export const TVCard = (item) => {
  return (
    <Card
      sx={{
        display: "flex",
        flexDirection: "column",
        height: "100%",
      }}
    >
      <CardContent>
        <Box
          sx={{
            display: "flex",
            justifyContent: "center",
            pb: 3,
          }}
        >
          <Avatar
            src="https://www.blog.uporabnastran.si/wp-content/uploads/2021/03/EON-Telemach-aplikacija-1024x539.jpg"
            variant="square"
          />
        </Box>
        <Typography align="center" gutterBottom variant="h5">
          {item.item.naziv}
        </Typography>
        <Typography align="center" variant="body1">
          {item.item.dodatno.split(",").map((item, index) => (
            <p key={index}>
              <span>&#8226;</span> {item.trim()}
            </p>
          ))}
          <Button
            startIcon={
              <SvgIcon fontSize="small">
                <PlusIcon />
              </SvgIcon>
            }
            variant="contained"
          >
            Izberi
          </Button>
        </Typography>
      </CardContent>
      <Box sx={{ flexGrow: 1 }} />
      <Divider />
      <Stack
        alignItems="center"
        direction="row"
        justifyContent="space-between"
        spacing={2}
        sx={{ p: 2 }}
      >
        <Stack alignItems="center" direction="row" spacing={1}>
          <Typography color="text.secondary" display="inline" variant="body2">
            {item.item.cena}€/m
          </Typography>
        </Stack>
        <Stack alignItems="center" direction="row" spacing={1}>
          <Typography color="text.secondary" display="inline" variant="body2">
            {item.item.steviloProgramov} programov
          </Typography>
        </Stack>
      </Stack>
    </Card>
  );
};
