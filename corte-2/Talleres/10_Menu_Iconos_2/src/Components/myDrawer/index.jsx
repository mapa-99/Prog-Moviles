// In App.js in a new project

import React from "react";
import { createDrawerNavigator } from "@react-navigation/drawer";
import "react-native-gesture-handler";
import HomeScreen from "../../pages/HomeScreen";
import ProfileScreen from "../../pages/ProfileScreen";
import NotificationScreen from "../../pages/NotificationScreen";
import Menu from "../Menu/Menu";
import { navigationRef } from "../../RootNavigation";
import { NavigationContainer } from "@react-navigation/native";

const Drawer = createDrawerNavigator();

function MyDrawer() {
  return (
    <NavigationContainer ref={navigationRef}>
      <Drawer.Navigator
        useLegacyImplementation={true}
        drawerContent={(props) => <Menu navigation {...props} />}
      >
        <Drawer.Screen name="Home" component={HomeScreen} />
        <Drawer.Screen name="Profile" component={ProfileScreen} />
        <Drawer.Screen name="Notification" component={NotificationScreen} />
      </Drawer.Navigator>
    </NavigationContainer>
  );
}

export default MyDrawer;
