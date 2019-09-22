import React, { Component } from 'react';
import Pingvin from "./Pingvin";
import './Pingvin.css';

class VisPingvinerMedBackend extends Component {
  constructor(){
    super();
    this.state = {
      registrertePingviner: [],
      tekstFraInputfelt: ""
    }
  }

  componentWillMount() {
    fetch("http://localhost:8080/pingviner",
      {
        method:"GET"
      }
    ).then(svarFraBackend => svarFraBackend.json())
    .then(svarFraBackend => this.setState({registrertePingviner: svarFraBackend.pingviner}));
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

      fetch("http://localhost:8080/pingviner",
        {
          method: "POST",
          headers: {"Content-Type": "application/json"},
          body: JSON.stringify(nyPingvin)
        })
      .then(svarFraBackend => svarFraBackend.json())
      .then(svarFraBackend => this.setState(
        {
          registrertePingviner: [...this.state.registrertePingviner, svarFraBackend],
          tekstFraInputfelt: ""
        }
      ));
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

export default VisPingvinerMedBackend;
