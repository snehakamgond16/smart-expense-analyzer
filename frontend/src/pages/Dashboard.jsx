import { useNavigate } from "react-router-dom";

function Dashboard() {
  const navigate = useNavigate();

  const user = JSON.parse(localStorage.getItem("user"));

  const handleLogout = () => {
    localStorage.removeItem("user");
    navigate("/");
  };

  return (
    <div style={styles.container}>
      
      {/* HEADER */}
      <div style={styles.header}>
        <h2>Smart Expense Analyzer</h2>

        <div>
          <span style={{ marginRight: "20px" }}>
            Welcome, {user?.name}
          </span>

          <button onClick={handleLogout} style={styles.logoutBtn}>
            Logout
          </button>
        </div>
      </div>

      {/* MAIN CONTENT */}
      <div style={styles.main}>

        <h1>Dashboard</h1>

        <div style={styles.cardContainer}>

          <div style={styles.card}>
            <h3>Total Expenses</h3>
            <p>₹ 0</p>
          </div>

          <div style={styles.card}>
            <h3>This Month</h3>
            <p>₹ 0</p>
          </div>

          <div style={styles.card}>
            <h3>Top Category</h3>
            <p>—</p>
          </div>

        </div>

      </div>
    </div>
  );
}

export default Dashboard;

const styles = {
  container: {
    fontFamily: "Arial",
    background: "#f4f6f8",
    minHeight: "100vh"
  },

  header: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    padding: "15px 30px",
    background: "#1976d2",
    color: "white"
  },

  logoutBtn: {
    background: "#fff",
    color: "#1976d2",
    border: "none",
    padding: "8px 16px",
    cursor: "pointer",
    borderRadius: "5px",
    fontWeight: "bold"
  },

  main: {
    padding: "40px"
  },

  cardContainer: {
    display: "flex",
    gap: "20px",
    marginTop: "20px"
  },

  card: {
    background: "white",
    padding: "25px",
    borderRadius: "10px",
    boxShadow: "0 2px 8px rgba(0,0,0,0.1)",
    minWidth: "200px"
  }
};