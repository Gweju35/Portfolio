/** @type {import('tailwindcss').Config} config */
const config = {
    content: ["./src/**/*.{html,js,php,css,vue}", "./public/**/*.{html,js,php,css,vue}"],
    safelist: [
        'bg-pf-green',
        'bg-pf-darkblue',
        'bg-pf-deep-blue1',
        'bg-pf-deep-blue2',
        'bg-pf-white',
        'bg-[#6718e9]',
        'bg-[#d025ce]',
        'bg-[#e97518]',
        'bg-[#F83097]'
    ],
    theme: {
        fontFamily: {
            sans: ['"Open Sans"', 'sans-serif'],
            josefin: ['"Josefin Sans"', 'sans-serif'],
        },
        extend: {
            colors: {
                'pf-green' : '#08D565',
                'pf-darkblue' : '#191634',
                'pf-deep-blue1' : '#201D3A',
                'pf-deep-blue2' : '#2D2A4A',
                'pf-white' : '#FFFFFF',
            }, // Extend Tailwind's default colors
            container: {
                center: true,
                padding: '1rem'
            }
        },
    },
    plugins: [],
};

export default config;
