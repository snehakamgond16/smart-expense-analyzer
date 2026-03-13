function Dashboard() {
  const user = JSON.parse(localStorage.getItem("user"));

  return (
    <div style={{ padding: "40px" }}>
      <h1>Welcome {user?.name} 🎉</h1>
      <p>Your Smart Expense Analyzer dashboard is ready.</p>
    </div>
  );
}

export default Dashboard;