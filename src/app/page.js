'use client'

import Link from "next/link";

export default function Home(){
    return(
        <main>
            <div>
                <Link href={"kunden"}>Kunden</Link>
                <br/>
                <Link href={"policen"}>Policen</Link>
                <br/>
                <Link href={"zahlungen.js"}>Zahlungen</Link>
            </div>
        </main>
    )
}