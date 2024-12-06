module.exports = {
    preset: 'ts-jest', // Tells Jest to use ts-jest for TypeScript
    testEnvironment: 'node', // The test environment (you can change it to 'jsdom' if you're testing frontend code)
    transform: {
        '^.+\\.ts$': 'ts-jest', // Tells Jest to use ts-jest for files ending with .ts
        '^.+\\.tsx$': 'ts-jest' // Tells Jest to use ts-jest for files ending with .tsx (if you're using React)
    },
    testMatch: [
        '**/?(*.)+(spec|test).ts', // Matches any file ending in .spec.ts or .test.ts
    ],
    moduleFileExtensions: ['ts', 'tsx', 'js', 'jsx', 'json', 'node'],
};
