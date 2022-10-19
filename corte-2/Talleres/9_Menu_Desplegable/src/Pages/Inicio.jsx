import { StyleSheet, Text, View } from "react-native";
import React from "react";

const inicio = () => {
  return (
    <View style={styles.container}>
      <Text>Pantalla 1</Text>
      <Text>Inicio</Text>
    </View>
  );
};

export default inicio;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
