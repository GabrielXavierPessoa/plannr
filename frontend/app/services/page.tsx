import Link from "next/link";
import ServiceCard from "@/components/ServiceCard";
import { services } from "@/lib/services";
import styles from "./services.module.css";

export default function ServicesPage() {
  return (
    <main className={styles.page}>
      <section className={styles.content}>
        <div className={styles.headingRow}>
          <Link
            href="/"
            aria-label="Voltar para a página inicial"
            className={styles.backLink}
          >
            <svg
              aria-hidden="true"
              viewBox="0 0 24 24"
              className={styles.backIcon}
              fill="none"
              stroke="currentColor"
              strokeWidth={2}
              strokeLinecap="round"
              strokeLinejoin="round"
            >
              <path d="M19 12H5" />
              <path d="m12 19-7-7 7-7" />
            </svg>
          </Link>
          <h1 className={styles.title}>Nossos serviços</h1>
        </div>

        <p className={styles.description}>
          Encontre o serviço ideal para você.
        </p>

        <div className={styles.servicesGrid}>
          {services.map((service) => (
            <ServiceCard key={service.name} service={service} />
          ))}
        </div>
      </section>
    </main>
  );
}
