"use client";

import { useState } from "react";
import { serviceCurrency, services } from "@/lib/services";
import styles from "./services.module.css";

export default function ServiceSelection() {
  const [selectedService, setSelectedService] = useState<string | null>(
    services[1]?.name ?? null,
  );

  return (
    <section className={styles.section} aria-labelledby="services-title">
      <div className={styles.heading}>
        <h1 id="services-title" className={styles.title}>
          Escolha um serviço
        </h1>
        <p className={styles.step}>Passo 1 de 3</p>
      </div>

      <div className={styles.servicesGrid}>
        {services.map((service) => {
          const isSelected = selectedService === service.name;

          return (
            <article
              key={service.name}
              className={`${styles.card} ${isSelected ? styles.cardSelected : ""}`}
            >
              <div
                aria-hidden="true"
                className={`${styles.serviceIcon} ${isSelected ? styles.serviceIconSelected : ""}`}
              />

              {isSelected && <span className={styles.selectedBadge}>Escolhido</span>}

              <h2 className={styles.serviceName}>{service.name}</h2>
              <p className={styles.description}>{service.description}</p>
              <p className={styles.summary}>
                {service.durationMinutes} min · {serviceCurrency.format(service.price)}
              </p>

              <button
                type="button"
                aria-pressed={isSelected}
                className={`${styles.selectButton} ${isSelected ? styles.selectButtonSelected : ""}`}
                onClick={() => setSelectedService(service.name)}
              >
                {isSelected ? "Selecionado" : "Selecionar"}
              </button>
            </article>
          );
        })}
      </div>

      <div className={styles.continueRow}>
        <a href="#" className={styles.continueButton}>
          Continuar
        </a>
      </div>
    </section>
  );
}
