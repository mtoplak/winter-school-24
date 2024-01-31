import PropTypes from "prop-types";
import {
  Avatar,
  Box,
  Card,
  CardContent,
  LinearProgress,
  Stack,
  SvgIcon,
  Typography,
} from "@mui/material";
import UsersIcon from "@heroicons/react/24/solid/UsersIcon";

export const OverviewTasksProgress2 = (props) => {
  const { value, sx, ime } = props;

  return (
    <Card sx={sx}>
      <CardContent>
        <Stack alignItems="flex-start" direction="row" justifyContent="space-between" spacing={3}>
          <Stack spacing={1}>
            <Typography color="text.secondary" gutterBottom variant="overline">
              {ime}
            </Typography>
            <Typography variant="h4">{value}%</Typography>
          </Stack>
          <Avatar
            sx={{
              backgroundColor: "warning.main",
              height: 56,
              width: 56,
            }}
          >
            <SvgIcon>
              <UsersIcon />
            </SvgIcon>
          </Avatar>
        </Stack>
        <Box sx={{ mt: 3 }}>
          1<LinearProgress value={value} variant="determinate" />
          31
        </Box>
      </CardContent>
    </Card>
  );
};

OverviewTasksProgress2.propTypes = {
  value: PropTypes.number.isRequired,
  sx: PropTypes.object,
};
