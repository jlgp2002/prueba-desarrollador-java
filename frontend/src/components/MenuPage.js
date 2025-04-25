import React from "react";
import { Button } from "react-bootstrap";
import { Link } from "react-router-dom";

function MenuPage() {
	return (
		<div className="container text-center mt-5">
			<img src="employee.svg" alt="Logo" width="150" className="mb-4" />
			<h1>Welcome to the Employee Finder</h1>
			<Link to="/employee-search">
				<Button variant="primary" size="lg" className="mt-4">
					Search Employee
				</Button>
			</Link>
		</div>
	);
}

export default MenuPage;
