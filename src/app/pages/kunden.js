'use client'
import KundenList from '../components/KundenList';
import styles from '../styles/Home.module.css';
import {fetchKunden} from "@/app/pages/api";

export async function getServerSideProps() {
    const kunden = await fetchKunden();
    return { props: { kunden } };
}



export default function Kunden({ kunden }) {
    return (
        <div className={styles.container}>
            <h1 className={styles.title}>Kunden</h1>
            <KundenList kunden={kunden} />
        </div>
    );
}
