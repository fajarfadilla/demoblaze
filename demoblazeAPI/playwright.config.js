import { defineConfig } from "@playwright/test";
export default defineConfig({
  testDir: "./tests",
  fullyParallel: true,
  use: {
    // All requests we send go to this API endpoint.
    baseURL: "https://api.demoblaze.com",
  },
});
