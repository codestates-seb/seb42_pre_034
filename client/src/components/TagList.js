function TagList({fetchedTags}) {
  return (
    <ul className="flex gap-1">
      {fetchedTags.map((el, idx) => (
        <li className="text-sm px-1 text-[#39739D] bg-[#E1ECF4] w-auto rounded-md" key={idx}>
          {el}
        </li>
      ))}
    </ul>
  )
}

export default TagList