import React from "react";
import { Link as RouterLink } from "react-router-dom";
import {
  Container,
  TextField,
  Button,
  Typography,
  Box,
  Paper,
  Link
} from "@mui/material";

function Login() {
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
          
          {/* Title */}
          <Typography variant="h4" align="center" gutterBottom>
            Smart Expense Analyzer 💰
          </Typography>

          <Typography variant="subtitle1" align="center" gutterBottom>
            Login to your account
          </Typography>

          {/* Form */}
          <Box component="form" sx={{ mt: 2 }}>
            
            <TextField
              fullWidth
              label="Email"
              type="email"
              margin="normal"
              required
            />

            <TextField
              fullWidth
              label="Password"
              type="password"
              margin="normal"
              required
            />

            <Button
              fullWidth
              variant="contained"
              size="large"
              sx={{ mt: 2 }}
            >
              Login
            </Button>

            {/* Links */}
            <Box
              sx={{
                display: "flex",
                justifyContent: "space-between",
                mt: 2
              }}
            >
              <Link href="#" underline="hover">
                Forgot Password?
              </Link>

              <Link component={RouterLink} to="/signup" underline="hover">
                Sign Up
            </Link>
            </Box>

          </Box>
        </Paper>
      </Box>
    </Container>
  );
}

export default Login;