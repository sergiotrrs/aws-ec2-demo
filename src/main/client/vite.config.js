import { defineConfig } from 'vite';

// https://vitejs.dev/config/
export default defineConfig({
  build: {
    outDir: '../resources/static/',
    emptyOutDir: true,
  },
})