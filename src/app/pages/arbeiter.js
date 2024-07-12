'use client'
import {fetchArbeiter} from "@/app/pages/api";

export async function getServerSideProps() {
    const arbeiter = await fetchArbeiter();
    return { props: { arbeiter } };
}

export default function Arbeiter({ arbeiter }) {
    return (
        <div>
            <h1>Arbeiter</h1>
            <ul>
                {arbeiter.map((arbeiter) => (
                    <li key={arbeiter.id}>{arbeiter.name}</li>
                ))}
            </ul>
        </div>
    );
}
