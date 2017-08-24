/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text, TouchableOpacity,
    View
} from 'react-native';
import CardView from './component/CardView'
import {NativeModules} from 'react-native';
import App from "./App";

export default class NativeModuleDemo extends Component {

    constructor(props) {
        super(props)
        this.state = {
            messsage: '',
        }
    }

    showSnackbar = () => {
        NativeModules.SnackbarAndroid.show('Ahihi Snackbar', NativeModules.SnackbarAndroid.SHORT)
    }

    showActionSnackbar = () => {
        NativeModules.SnackbarAndroid.showWithAction('The message has been deleted', "Undo", () => {
            this.setState({
                message: 'The message has been recreated',
            })
        })
    }

    add = () => {
        NativeModules.Math.add([1, 2, 3, 4, 6]).then((result) => {
            this.setState({
                message: result
            })
        })
    }

    double = () => {
        NativeModules.Math.doubleValue([1, 2, 3, 4, 6]).then((result) => {
            this.setState({
                message: result.join(', ')
            })
        })
    }

    render() {
        return (
            <View style={styles.container}>
              <Text style={styles.instructions}>{this.state.message}</Text>
              <TouchableOpacity onPress={this.showSnackbar}>
                <Text>Show Snackbar
                </Text>
              </TouchableOpacity>

              <TouchableOpacity onPress={this.showActionSnackbar}>
                <Text>Show Snackbar with Action
                </Text>
              </TouchableOpacity>
              <TouchableOpacity onPress={this.add}>
                <Text>Add
                </Text>
              </TouchableOpacity>
              <TouchableOpacity onPress={this.double}>
                <Text>Double
                </Text>
              </TouchableOpacity>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
        padding: 10,
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});

AppRegistry.registerComponent('NativeModuleDemo', () => App);
