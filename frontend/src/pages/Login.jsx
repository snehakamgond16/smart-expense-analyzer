import React, { useState } from "react";
import {
  Container,
  TextField,
  Button,
  Typography,
  Box,
  Paper,
  Link
} from "@mui/material";
import { Link as RouterLink, useNavigate } from "react-router-dom";
import axios from "axios";

function Login() {
  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    email: "",
    password: ""
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:8080/api/users/login",
        formData
      );

      alert("Login successful 🎉");

      // Save user in local storage
      localStorage.setItem("user", JSON.stringify(response.data));

      // Redirect to dashboard
      navigate("/dashboard");

    } catch (error) {
      alert("Invalid email or password ❌");
      console.error(error);
    }
  };

  return (
    <Container maxWidth="sm">
      <Box
        sx={{
          height: "100vh",
          display: "flex",
          alignItems: "center",
          justifyContent: "center"
        }}
      >
        <Paper elevation={6} sx={{ padding: 4, width: "100%" }}>
          
          <Typography variant="h4" align="center" gutterBottom>
            Smart Expense Analyzer 💰
          </Typography>

          <Typography align="center">Login to your account</Typography>

          <Box component="form" onSubmit={handleSubmit} sx={{ mt: 2 }}>
            
            <TextField
              fullWidth
              label="Email"
              name="email"
              type="email"
              margin="normal"
              required
              onChange={handleChange}
            />

            <TextField
              fullWidth
              label="Password"
              name="password"
              type="password"
              margin="normal"
              required
              onChange={handleChange}
            />

            <Button
              fullWidth
              variant="contained"
              size="large"
              type="submit"
              sx={{ mt: 2 }}
            >
              Login
            </Button>

            <Box
              sx={{
                display: "flex",
                justifyContent: "space-between",
                mt: 2
              }}
            >
              <Link component={RouterLink} to="/signup" underline="hover">
                Sign Up
              </Link>

              <Link href="#" underline="hover">
                Forgot Password?
              </Link>
            </Box>

          </Box>
        </Paper>
      </Box>
    </Container>
  );
}

export default Login;