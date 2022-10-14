import { StyleSheet, Text, View } from "react-native";
import React from "react";

const Contacto = () => {
  return (
    <View style={styles.container}>
      <Text>Pantalla 2</Text>
      <Text>Contacto</Text>
    </View>
  );
};

export default Contacto;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
