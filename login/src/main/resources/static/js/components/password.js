import React,{Component} from 'react';

class Password extends Component{
	constructor(props){
		super(props);
		
		this.state = {password:''};
		this.onInputChange = this.onInputChange.bind(this);
	}
	render(){
		return (
				<div>
					<div>
						<label className="sr-only">Şifre </label>
					</div>
					<div>
						<input className="form-control" 
						value={this.state.password} 
						onChange = {event => this.onInputChange(event.target.value)}/>
					</div>
				</div>
		);
	}
	onInputChange(password){
		this.setState({password});
		this.props.getPassword(password);
	}
}

export default Password;