import React,{Component} from 'react';
import ReactDom from 'react-dom';
import Login from './components/login';

class App extends Component{

	constructor(props){
		super(props);
	}
	render(){
		return (
				<Login />
		);
	}
}

ReactDom.render(<App/>, document.querySelector('.container'));