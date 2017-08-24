import React, {Component} from 'react';
import {
    AppRegistry,
    StyleSheet,
    Text, TouchableOpacity,
    View,
    Platform,
    PermissionsAndroid,
} from 'react-native';
import CardView from './component/CardView'
import {NativeModules} from 'react-native';

export default class App extends Component {

    componentWillMount() {
        if (Platform.OS === 'android') {
            this.requestCameraPermission();
        }
    }

    requestCameraPermission = async () => {
        try {
            const granted = await PermissionsAndroid.request(
                PermissionsAndroid.PERMISSIONS.CAMERA,
                {
                    'title': 'Cool Photo App Camera Permission',
                    'message': 'Cool Photo App needs access to your camera ' +
                    'so you can take awesome pictures.'
                }
            );
            if (granted === PermissionsAndroid.RESULTS.GRANTED) {
                alert("You can use the camera")
            } else {
                alert("Camera permission denied")
            }
        } catch (err) {
            console.warn(err)
        }
    };

    render() {
        return (
            <View style={{flex: 1, backgroundColor: 'white'}}>
                <CardView style={{flex: 1, alignItems: 'center', justifyContent: 'center'}} cardCornerRadius={100} cardElevation={10}>
                    <View style={{}}>
                        <View style={{ alignItems: 'center', backgroundColor: 'green', padding: 20}}>
                            <TouchableOpacity>
                                <Text>Hello</Text>
                            </TouchableOpacity>
                        </View>
                        <View style={{alignItems: 'center', backgroundColor: 'red', padding: 20}}>
                            <TouchableOpacity>
                                <Text>World</Text>
                            </TouchableOpacity>
                        </View>
                    </View>
                </CardView>
            </View>
        )
    }
}