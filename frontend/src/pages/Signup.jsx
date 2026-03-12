import React from "react";
import {
  Container,
  TextField,
  Button,
  Typography,
  Box,
  Paper,
  Link
} from "@mui/material";

function Signup() {
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

          <Box component="form" sx={{ mt: 2 }}>
            
            <TextField fullWidth label="Name" margin="normal" required />
            
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
              Sign Up
            </Button>

            <Box sx={{ textAlign: "center", mt: 2 }}>
              <Link href="/" underline="hover">
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