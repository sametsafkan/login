import React,{Component} from 'react';

class UserName extends Component{
	constructor(props){
		super(props);
		
		this.state = {userName:''};
		this.onInputChange = this.onInputChange.bind(this);
	}
	render(){
		return (
				<div>
					<div>
						<label className="sr-only">Kullanıcı Adı </label>
					</div>
					<div>
						<input className="form-control"
						value={this.state.userName} 
						onChange = {event => this.onInputChange(event.target.value)}/>
					</div>
				</div>
		);
	}
	onInputChange(userName){
		this.setState({userName});
		this.props.getUserName(userName);
	}
}

export default UserName;