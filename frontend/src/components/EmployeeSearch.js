import React, { useState } from "react";

function EmployeeSearch() {
	const [employeeId, setEmployeeId] = useState("");
	const [employees, setEmployees] = useState([]);
	const [error, setError] = useState("");

	const handleSearch = async () => {
		const url = employeeId.trim()
			? `http://localhost:8080/api/employees/${employeeId}`
			: "http://localhost:8080/api/employees";

		try {
			setError("");
			const response = await fetch(url);

			if (response.status === 429) 
				throw new Error("Too many requests. Please try again later.");
			if (!response.ok) 
				throw new Error("Failed to fetch employee data.");
	
			const data = await response.json();
			setEmployees(Array.isArray(data) ? data : [data]);
		} catch (err) {
			setEmployees([]);
			setError(err.message);
		}
	};

	return (
		<div className="container mt-4">
			<h2>Employee Search</h2>
			<div className="input-group mb-3">
				<input
					type="text"
					className="form-control"
					placeholder="Enter Employee ID"
					value={employeeId}
					onChange={(e) => setEmployeeId(e.target.value)}
				/>
				<button className="btn btn-primary" onClick={handleSearch}>
					Search
				</button>
			</div>

			{error && <div className="alert alert-danger">{error}</div>}

			{employees.length > 0 && (
				<table className="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Salary</th>
							<th>Annual Salary</th>
						</tr>
					</thead>
					<tbody>
						{employees.map((emp) => (
							<tr key={emp.id}>
								<td>{emp.id}</td>
								<td>{emp.employee_name}</td>
								<td>{emp.employee_salary}</td>
								<td>{emp.employee_salary * 12}</td>
							</tr>
						))}
					</tbody>
				</table>
			)}
		</div>
	);
}

export default EmployeeSearch;
