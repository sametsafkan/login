import React,{Component} from 'react';
import UserName from './user-name';
import Password from './password';
import LoginButton from './button';

class Login extends Component{
	constructor(props){
		super(props);
		this.state = {
				userName: '',
				password: ''
		};
	}
	setUserName(name){
		this.setState({userName: name});
	}
	setPassword(pass){
		this.setState({password: pass});
	}
	render(){
		return(
				<div className="login-form-1">
					<form id="login-form" className="text-left">
						<div className="login-form-main-message"></div>
						<div className="login-group">
							<div className="form-group">
								<div>
									<UserName getUserName = {userName => this.setUserName(userName)} />
								</div>
							</div>
							<div className="form-group">
								<Password getPassword = {password => this.setPassword(password)} />
							</div>
							<LoginButton 
							userName = {this.state.userName}
							password = {this.state.password}
							/>
						</div>
					</form>
				</div>
		);
	}
}

export default Login;