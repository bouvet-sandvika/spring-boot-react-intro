import React, { Component } from 'react';
import Pingvin from "./Pingvin";
import './Pingvin.css';

class VisPingviner extends Component {
  constructor(){
    super();
    this.state = {
      registrertePingviner: [],
      tekstFraInputfelt: ""
    }
  }

  render() {
    // Funksjon som skal kalles når noe i input-feltet endrer seg
    const oppdaterInput = event => {
      const oppdatertTekstFraInputfelt = event.target.value;
      this.setState({tekstFraInputfelt: oppdatertTekstFraInputfelt});
    }

    // Funksjon som skal kalles når jeg trykker på 'Registrer'-knappen
    const registrerPingvin = () => {
      if(this.state.tekstFraInputfelt.trim() === ""){
        return;
      }

      const nyPingvin = {navn: this.state.tekstFraInputfelt};
      this.setState(
        {
          registrertePingviner: [...this.state.registrertePingviner, nyPingvin],
          tekstFraInputfelt: ""
        }
      );
    }

    const pingviner = this.state.registrertePingviner.map(
      (pingvin, key) => <Pingvin navn={pingvin.navn} key={key} />
    );

    return (
      <div style={{marginTop:"50px"}}>
        {"Registrer Pingvin: "}
        <input
          className="pingvin-input"
          onChange={oppdaterInput}
          value={this.state.tekstFraInputfelt}
        />

        <button
          className="pingvin-knapp"
          onClick={registrerPingvin}
        >
          {"Registrer"}
        </button>

        <div className="pingvin-div">
          {pingviner}
        </div>
	    </div>
    );
  }
}

export default VisPingviner;
