import "bootstrap/dist/css/bootstrap.min.css";
import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import MenuPage from "./components/MenuPage";
import EmployeeSearch from "./components/EmployeeSearch";

function App() {
	return (
		<Router>
			<Routes>
				<Route path="/" element={<MenuPage />} />
				<Route path="/employee-search" element={<EmployeeSearch />} />
			</Routes>
		</Router>
	);
}

export default App;
