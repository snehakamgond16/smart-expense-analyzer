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
import { Link as RouterLink } from "react-router-dom";
import axios from "axios";

function Signup() {
  const [formData, setFormData] = useState({
    name: "",
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
        "http://localhost:8080/api/users/register",
        formData
      );

      alert("User registered successfully 🎉");
      console.log(response.data);

    } catch (error) {
      alert("Registration failed ❌");
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
            Create Account ✨
          </Typography>

          <Box component="form" onSubmit={handleSubmit} sx={{ mt: 2 }}>
            
            <TextField
              fullWidth
              label="Name"
              name="name"
              margin="normal"
              required
              onChange={handleChange}
            />

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
              Sign Up
            </Button>

            <Box sx={{ textAlign: "center", mt: 2 }}>
              <Link component={RouterLink} to="/" underline="hover">
                Already have an account? Login
              </Link>
            </Box>

          </Box>
        </Paper>
      </Box>
    </Container>
  );
}

export default Signup;