import ClockIcon from "@heroicons/react/24/solid/ClockIcon";
import {
  Avatar,
  Box,
  Button,
  Card,
  CardContent,
  Divider,
  Stack,
  SvgIcon,
  Typography,
} from "@mui/material";
import PlusIcon from "@heroicons/react/24/solid/PlusIcon";
import { useSubContext } from "src/contexts/SubContext";

export const PhoneCard = (item) => {
  const { subState, setSubState, setStroski } = useSubContext();

  const narociSe = (item2) => {
    console.log("naročeno");
    const updatedState = [...subState];
    updatedState.push(item2);
    setSubState(updatedState);
    setStroski((prevStroski) => prevStroski + item2.cena);
  };

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
            src="https://www.a1.si/o/commerce-media/products/48367568/a1_minimio/190825441/miniMIO.png?download=false"
            variant="square"
          />
        </Box>
        <Typography align="center" gutterBottom variant="h5">
          {item.item.naziv}
        </Typography>
        <Typography align="center" variant="body1">
          <p>
            <span>&#8226;</span> {item.item.prenosPodatkov} GB prenosa podatkov v EU/EEA
          </p>
          <p>
            <span>&#8226;</span> {item.item.steviloMinut} minut v Sloveniji v vsa mobilna omrežja
          </p>
          <Button
            startIcon={
              <SvgIcon fontSize="small">
                <PlusIcon />
              </SvgIcon>
            }
            variant="contained"
            onClick={() => narociSe(item.item)}
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
          <SvgIcon color="action" fontSize="small">
            <ClockIcon />
          </SvgIcon>
          <Typography color="text.secondary" display="inline" variant="body2">
            {item.item.cena}€/m
          </Typography>
        </Stack>
        <Stack alignItems="center" direction="row" spacing={1}>
          <Typography color="text.secondary" display="inline" variant="body2">
            {item.item.hitrost}
          </Typography>
        </Stack>
      </Stack>
    </Card>
  );
};
