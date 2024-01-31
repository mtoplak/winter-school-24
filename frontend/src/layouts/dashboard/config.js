import ChartBarIcon from "@heroicons/react/24/solid/ChartBarIcon";
import CogIcon from "@heroicons/react/24/solid/CogIcon";
import ShoppingBagIcon from "@heroicons/react/24/solid/ShoppingBagIcon";
import UserIcon from "@heroicons/react/24/solid/UserIcon";
import { SvgIcon } from "@mui/material";
import GlobeAltIcon from "@heroicons/react/24/solid/GlobeAltIcon";
import TVIcon from "@heroicons/react/24/solid/TVIcon";
import Phone from "@heroicons/react/24/solid/PhoneIcon";

export const items = [
  {
    title: "Overview",
    path: "/",
    icon: (
      <SvgIcon fontSize="small">
        <ChartBarIcon />
      </SvgIcon>
    ),
  },
  {
    title: "Internet",
    path: "/internet",
    icon: (
      <SvgIcon fontSize="small">
        <GlobeAltIcon />
      </SvgIcon>
    ),
  },
  {
    title: "TV",
    path: "/tv",
    icon: (
      <SvgIcon fontSize="small">
        <TVIcon />
      </SvgIcon>
    ),
  },
  {
    title: "Phone",
    path: "/phone",
    icon: (
      <SvgIcon fontSize="small">
        <Phone />
      </SvgIcon>
    ),
  },
  // {
  //   title: "Customers",
  //   path: "/customers",
  //   icon: (
  //     <SvgIcon fontSize="small">
  //       <UsersIcon />
  //     </SvgIcon>
  //   ),
  // },
  {
    title: "Companies",
    path: "/companies",
    icon: (
      <SvgIcon fontSize="small">
        <ShoppingBagIcon />
      </SvgIcon>
    ),
  },
  {
    title: "Account",
    path: "/account",
    icon: (
      <SvgIcon fontSize="small">
        <UserIcon />
      </SvgIcon>
    ),
  },
  {
    title: "Settings",
    path: "/settings",
    icon: (
      <SvgIcon fontSize="small">
        <CogIcon />
      </SvgIcon>
    ),
  },
  // {
  //   title: 'Error',
  //   path: '/404',
  //   icon: (
  //     <SvgIcon fontSize="small">
  //       <XCircleIcon />
  //     </SvgIcon>
  //   )
  // }
];
