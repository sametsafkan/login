import React, {Component} from 'react';

class LoginButton extends Component{
	constructor(props){
		super(props);
		this.state = {
			userName: props.userName,
			password: props.password
		};
	}
	render(){
		return(
				<div>
					<button type="button" onClick = {event => this.onLogin()} className="btn-secondary">Giriş</button>
				</div>
		);
	}
	onLogin(){
		console.log(this.state.userName);
		console.log(this.state.password);
		window.location.replace("login.do?userName=" + this.props.userName + "&password=" + this.props.password);
	}
}


export default LoginButton;