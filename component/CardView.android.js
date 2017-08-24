import PropTypes from 'prop-types';
import { requireNativeComponent, View } from 'react-native';

var iface = {
    name: 'CardView',
    propTypes: {
        cardElevation: PropTypes.number,
        cardCornerRadius: PropTypes.number,
        ...View.propTypes // include the default view properties
    },
};

export default requireNativeComponent('RCTCardView', iface);