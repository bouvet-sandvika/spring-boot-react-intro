import React, { Component } from 'react';
import { GoogleLogin } from "react-google-login";

const clientId = "DIN_CLIENT_ID_KOMMER_HER";

const verifiserTokenMedBackend = token => {
  return fetch("http://localhost:8080/login", {
    method: "POST",
    headers: {
      Authorization: token
    }
  })
  .then(result => result.json());
}

const lagVisningstekst = (innloggetBruker) => {
  if(innloggetBruker === undefined){
    return "Ingen er logget inn!";
  } else {
    return innloggetBruker + " er logget inn!";
  }
}

class GoogleLoginDemo extends Component {
  constructor(){
    super();
    this.state = {
      innloggetBruker: undefined
    }
  }

  render() {
    return (
      <div>
        <h1>{lagVisningstekst(this.state.innloggetBruker)}</h1>
        <GoogleLogin
          buttonText={"Logg inn med Google"}
          clientId={clientId}
          onSuccess={response => {
            verifiserTokenMedBackend(response.tokenId)
            .then(svarFraBackend => this.setState({innloggetBruker: svarFraBackend.innloggetBruker}))
          }}
          onFailure={response => alert(response)}
        />
      </div>
    );
  }
}

export default GoogleLoginDemo;
