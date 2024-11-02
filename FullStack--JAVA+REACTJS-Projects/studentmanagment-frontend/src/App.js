
import './App.css';
import Appbar from './components/Appbar';
import Student from './components/Student';


function App() {
  return (
    <div className="App">
      Welcome to Student Management System

      <Appbar></Appbar>
      <Student></Student>
    </div>
  );
}

export default App;
