import React, { Component } from 'react';
import pingvin from './pingvin.svg';

class Pingvin extends Component {

  render() {
    const navnPaaPingvin = this.props.navn;

    return (
      <div>
        <img
          alt={this.props.navn}
          src={pingvin}
          style={{height: "150px"}} />
        <p>{navnPaaPingvin}</p>
      </div>
    );
  }
}

export default Pingvin;
