import styles from "./ServiceCard.module.css";

type Service = {
  name: string;
  description: string;
  price: number;
  durationMinutes: number;
  illustration: "barber" | "manicure" | "massage";
};

type ServiceCardProps = {
  service: Service;
};

const currency = new Intl.NumberFormat("pt-BR", {
  style: "currency",
  currency: "BRL",
});

const illustrations = {
  barber: (
    <>
   {/*    <circle cx="12" cy="7" r="3" />
      <circle cx="12" cy="17" r="3" />
      <path d="m14.2 9.2 6 6M14.2 14.8l6-6" /> */}
    </>
  ),
  manicure: (
    <>
     {/*  <path d="M8 20V9a2 2 0 0 1 4 0v5-8a2 2 0 0 1 4 0v8-5a2 2 0 0 1 4 0v7a5 5 0 0 1-5 5h-2a5 5 0 0 1-5-5Z" />
      <path d="m8 15-2-2a2 2 0 0 0-3 3l4 5" /> */}
    </>
  ),
  massage: (
    <>
     {/*  <path d="M12 4a2 2 0 1 0 0 4 2 2 0 0 0 0-4Z" />
      <path d="m7 13 3-3 3 2 4 1M5 19l4-4 3 2 5-1 2 2M15 11l3-3 2 1" /> */}
    </>
  ),
};

export default function ServiceCard({ service }: ServiceCardProps) {
  return (
    <article className={styles.card}>
      <div
        aria-label={`Ilustração de ${service.name}`}
        role="img"
        className={styles.illustration}
      >
        <div className={styles.illustrationBadge}>
          <svg
            aria-hidden="true"
            viewBox="0 0 24 24"
            className={styles.illustrationIcon}
            fill="none"
            stroke="currentColor"
            strokeWidth="1.6"
            strokeLinecap="round"
            strokeLinejoin="round"
          >
            {illustrations[service.illustration]}
          </svg>
        </div>
      </div>

      <div className={styles.content}>
        <h3 className={styles.name}>{service.name}</h3>
        <p className={styles.description}>{service.description}</p>

        <div className={styles.details}>
          <div>
            <p className={styles.priceLabel}>Preço (exemplo)</p>
            <p className={styles.price}>{currency.format(service.price)}</p>
          </div>
          <p className={styles.duration}>{service.durationMinutes} min</p>
        </div>

        <button type="button" className={styles.button}>
          Ver detalhes
        </button>
      </div>
    </article>
  );
}
